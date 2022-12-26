package com.kw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_user2.*
import java.io.File
import java.io.FileOutputStream
import java.security.MessageDigest


class AddUserActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user2)
        var str = ""

        button01.setOnClickListener {
            EnterThePin("0")
            str += "0"
        }
        button11.setOnClickListener {
            EnterThePin("1")
            str += "2"
        }
        button21.setOnClickListener {
            EnterThePin("2")
            str += "2"
        }
        button31.setOnClickListener {
            EnterThePin("3")
            str += "3"
        }
        button41.setOnClickListener {
            EnterThePin("4")
            str += "4"
        }
        button51.setOnClickListener {
            EnterThePin("5")
            str += "5"
        }
        button61.setOnClickListener {
            EnterThePin("6")
            str += "6"
        }
        button71.setOnClickListener {
            EnterThePin("7")
            str += "7"
        }
        button81.setOnClickListener {
            EnterThePin("8")
            str += "8"
        }
        button91.setOnClickListener {
            EnterThePin("9")
            str += "9"
        }
        buttonReshotk1.setOnClickListener {
            EnterThePin("#")
            str += "#"
        }
        buttonStar1.setOnClickListener {
            EnterThePin("*")
            str += "*"
        }

        buttonCreate.setOnClickListener  {
            val StartAct = Intent (this, SecondActivity::class.java)
            startActivity(StartAct)
            save(str)
        }
        buttonDelete1.setOnClickListener {
            enterethepin1.text = ""
            str = ""
        }
    }
    private fun EnterThePin (pin: String) {
        enterethepin1.append(pin)
    }
    private fun hash(string: String): String {
        val bytes = string.toByteArray()
        val sha256 = MessageDigest.getInstance("SHA-256")
        val digest = sha256.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }
    fun save (str: String) {
        val newfile = openFileOutput("create", MODE_PRIVATE)
        var sha256 = hash(str).toByteArray()
        newfile.write(sha256)
    }
}