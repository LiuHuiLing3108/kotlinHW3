package com.example.kotlinhw3

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("請選擇功能")
                .setMessage("請根據下方按鈕選擇要顯示的物件")
                .setNeutralButton("取消"){dialog, which ->
                    Toast.makeText(this,"取消",Toast.LENGTH_SHORT).show()
                }
                    .setNegativeButton("自定義Toast"){dialog, which ->
                        Toast.makeText(this,"自定義Toast",Toast.LENGTH_SHORT).show()
                        showToast()
                    }
                    .setPositiveButton("顯示List"){dialog, which ->
                        Toast.makeText(this,"顯示List",Toast.LENGTH_SHORT).show()
                        showListDialog()
                    }.show()
        }
    }
    private fun showToast() {
        val toast = Toast(this)
        toast.setGravity(Gravity.TOP,0,50)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layoutInflater.inflate(R.layout.custom_toast,null)
        toast.show()
    }
    private fun showListDialog(){
        val list_item = arrayOf("message1","message2","message3","message4","message5")
        AlertDialog.Builder(this)
                .setTitle("使用List呈現")
                .setItems(list_item){dialogInterface,i ->
                    Toast.makeText(this,"你選的是"+list_item[i],Toast.LENGTH_SHORT).show()
                }.show()
    }
}

