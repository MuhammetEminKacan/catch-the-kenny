package com.emin.kacan.catchthekenny

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.emin.kacan.catchthekenny.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var score=0
    var imageArray= arrayListOf<ImageView>()
    var runnable=Runnable{}
    var handler= Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        imageArray.add(binding.imageView10)
        imageArray.add(binding.imageView11)
        imageArray.add(binding.imageView12)
        imageArray.add(binding.imageView13)
        imageArray.add(binding.imageView14)
        imageArray.add(binding.imageView15)
        imageArray.add(binding.imageView16)
        imageArray.add(binding.imageView17)
        imageArray.add(binding.imageView18)
        imageArray.add(binding.imageView19)
        imageArray.add(binding.imageView20)
        imageArray.add(binding.imageView21)
        imageArray.add(binding.imageView22)
        imageArray.add(binding.imageView23)
        imageArray.add(binding.imageView24)
        hideImage()

        object : CountDownTimer(30000,1000)
        {
            override fun onTick(millisUntilFinished: Long) {
                binding.txtTime.text="time: ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                binding.txtTime.text="time: 0"
                handler.removeCallbacks(runnable)

                for (image in imageArray)
                {
                    image.visibility=View.INVISIBLE
                }
                Toast.makeText(this@MainActivity, " ${binding.txtScore.text}", Toast.LENGTH_SHORT).show()
                val alert= AlertDialog.Builder(this@MainActivity)
                alert.setTitle("game over")
                alert.setMessage("yeniden oynamak istermisin")
                alert.setPositiveButton("evet",object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                         val intent = Intent(this@MainActivity,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }

                })
                alert.setNegativeButton("hayır"){p0,p1->
                    Toast.makeText(this@MainActivity,"oyun bitti", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@MainActivity,GirisEkrani::class.java)
                    startActivity(intent)
                    finish()

                }
                alert.show()

            }

        }.start()

    }

    fun hideImage()
    {
        // gizlemek için 2 mod var  biri invisible diğeri gone gone kullanırsak o layout içinden yokolurken invisible görünmez kılar
        // visible ise onu tekrardan görünür kılar

        val sonuc = degerler()

        runnable=object :Runnable{
            override fun run() {
                for (image in imageArray)
                {
                    image.visibility= View.INVISIBLE             // tüm resimleri gizledim
                }

                val random = Random
                val randomIndex=random.nextInt(24)
                imageArray[randomIndex].visibility= View.VISIBLE
                when(sonuc){
                    1 ->{
                        handler.postDelayed(runnable,1000)
                    }
                    2 ->{
                        handler.postDelayed(runnable,700)
                    }
                    3 ->{
                        handler.postDelayed(runnable,500)
                    }
                }

            }

        }
        handler.post(runnable)
    }
    fun sayiArttirma(view: View){
        score +=1
        binding.txtScore.text = "score:${score}"
    }
    fun degerler() : Int? {
        val intent = intent
        val deger  =intent.getIntExtra("level",0)
        return deger
    }

}