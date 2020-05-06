package com.example.json_file

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private val userList = mutableListOf<UserModel.UserData>()
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        adapter = RecyclerViewAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        parseJson()
    }

    private fun parseJson() {

        val userModel = UserModel()
        val json = JSONObject(JSON)

        if (json.has("page")) {
            userModel.page = json.getInt("page")
        }
        if (json.has("per_page")) {
            userModel.perPage = json.getInt("per_page")
        }
        if (json.has("total")) {
            userModel.total = json.getInt("total")
        }
        if (json.has("total_pages")) {
            userModel.totalPages = json.getInt("total_pages")
        }

        for (i in 0 until json.getJSONArray("data").length()) {
            val jsonObject = json.getJSONArray("data")[i] as JSONObject
            val data = UserModel.UserData()
            data.id = jsonObject.getInt("id")
            data.email = jsonObject.getString("email")
            data.firstName = jsonObject.getString("first_name")
            data.lastName = jsonObject.getString("last_name")
            data.avatar = jsonObject.getString("avatar")
            userModel.data.add(data)
            userList.add(data)
        }
    }
}
