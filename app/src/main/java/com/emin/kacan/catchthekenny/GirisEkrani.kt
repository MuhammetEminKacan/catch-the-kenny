package com.emin.kacan.catchthekenny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.emin.kacan.catchthekenny.databinding.ActivityGirisEkraniBinding

class GirisEkrani : AppCompatActivity() {
    private lateinit var binding: ActivityGirisEkraniBinding
    private var control = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGirisEkraniBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = "catch the stars"

        binding.zorlukSecimi.addOnButtonCheckedListener { group, checkedId, isChecked ->
            control = isChecked
            if (control){
                when(checkedId){
                    R.id.btnKolay -> {
                        binding.btnStart.setOnClickListener {
                            val intent = Intent(this,MainActivity::class.java)
                            intent.putExtra("level",1)
                            startActivity(intent)
                            finish()
                        }
                    }
                    R.id.btnOrta -> {
                        binding.btnStart.setOnClickListener {
                            val intent = Intent(this,MainActivity::class.java)
                            intent.putExtra("level",2)
                            startActivity(intent)
                            finish()
                        }

                    }
                    R.id.btnZor -> {
                        binding.btnStart.setOnClickListener {
                            val intent = Intent(this,MainActivity::class.java)
                            intent.putExtra("level",3)
                            startActivity(intent)
                            finish()
                        }

                    }
                }

            }
        }






    }

}