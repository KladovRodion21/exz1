package com.example.exp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Response
import com.example.exp1.db.Login
import com.example.exp1.db.MyRetrofit
import com.example.exp1.db.RetApi


class LoginActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var pass: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.txtEmail)
        pass = findViewById(R.id.txtPass)
    }

    fun login(view: android.view.View) {
        if(email.text.isNotEmpty() && pass.text.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email.text).matches())
        {
            val retrofit = MyRetrofit().getRetrofit().create(RetApi::class.java)
            val log = MyRetrofit().getRetrofit()
            val getApi=log.create(RetApi::class.java)
            var hashMap: HashMap<String,String> = HashMap <String, String>()
            hashMap.put("email" , email.text.toString())
            hashMap.put("password" , pass.text.toString())
            val log_call: retrofit2.Call<Login> = getApi.login(hashMap)

            log_call.enqueue(object: retrofit2.Callback<Login> {
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.body() != null) {

                        startActivity(Intent(this@LoginActivity,MenuActivity::class.java))
                        finish()

                    }
                    else AlertDialog.Builder(this@LoginActivity).setMessage("Неверные данные входа").create().show()


                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    val toast = Toast.makeText(this@LoginActivity,t.message, Toast.LENGTH_SHORT).show()
                }
            })




        }
        else{

            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Заполните все поля")
                .setPositiveButton("ОК",null)
                .create()
                .show()
        }




    }
}








