package com.example.recycleview

import android.os.Bundle
import android.widget.Adapter
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.asyifafahra.listdanbuku.model.ModelBuku
import com.example.recycleview.adapter.BuahAdapter
import com.example.recycleview.adapter.BukuAdapter
import com.example.recycleview.model.MockList
import com.example.recycleview.model.ModelBuah

class RecycleBuahActivity : ComponentActivity() {
    private lateinit var rv_buah: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_buah)

        rv_buah = findViewById(R.id.rv_buah)

        // Use GridLayoutManager with a span count
        rv_buah.layoutManager = GridLayoutManager(this, 1)

        // Set adapter
        val adapter = BuahAdapter(MockList.getModel() as ArrayList<ModelBuah>)
        rv_buah.adapter = adapter

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
