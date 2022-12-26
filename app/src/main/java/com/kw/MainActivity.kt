package com.kw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStream
import java.security.MessageDigest
import kotlin.io.println as println1


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var str = ""

        button0.setOnClickListener {
            EnterThePin("0")
            Error_txt.text = ""
            str += "0"
        }
        button1.setOnClickListener {
            EnterThePin("1")
            Error_txt.text = ""
            str += "1"
        }
        button2.setOnClickListener {
            EnterThePin("2")
            Error_txt.text = ""
            str += "2"
        }
        button3.setOnClickListener {
            EnterThePin("3")
            Error_txt.text = ""
            str += "3"
        }
        button4.setOnClickListener {
            EnterThePin("4")
            Error_txt.text = ""
            str += "4"
        }
        button5.setOnClickListener {
            EnterThePin("5")
            Error_txt.text = ""
            str += "5"
        }
        button6.setOnClickListener {
            EnterThePin("6")
            Error_txt.text = ""
            str += "6"
        }
        button7.setOnClickListener {
            EnterThePin("7")
            Error_txt.text = ""
            str += "7"
        }
        button8.setOnClickListener {
            EnterThePin("8")
            Error_txt.text = ""
            str += "8"
        }
        button9.setOnClickListener {
            EnterThePin("9")
            Error_txt.text = ""
            str += "9"
        }
        buttonReshotk.setOnClickListener {
            EnterThePin("#")
            Error_txt.text = ""
            str += "#"
        }
        buttonStar.setOnClickListener {
            EnterThePin("*")
            Error_txt.text = ""
            str += "*"
        }

        buttonDelete.setOnClickListener {
            enterethepin.text = ""
            Error_txt.text = ""
            str = ""
        }

        buttonEnter.setOnClickListener {
            val newfile = openFileInput("create")
            val read = InputStreamReader(newfile)
            var line = BufferedReader(read).readLine().toString()
            if (line == hash(str)) {
                val StartAct = Intent (this, SecondActivity::class.java)
                startActivity(StartAct)
            }
            else {
                ErrorView()
                str = ""
            }
        }

       new_user.setOnClickListener  {
            val StartAct = Intent (this, AddUserActivity2::class.java)
            startActivity(StartAct)

        }
    }

    fun EnterThePin (pin: String) {
        enterethepin.append(pin)
    }

    fun ErrorView () {
        Error_txt.append("Error")
        enterethepin.text = ""
    }
    fun hash(string: String): String {
        val bytes = string.toByteArray()
        val sha256 = MessageDigest.getInstance("SHA-256")
        val digest = sha256.digest(bytes)
        return digest.fold("") { str, it -> str + "%02x".format(it) }
    }
}