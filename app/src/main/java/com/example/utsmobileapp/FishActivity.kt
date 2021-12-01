package com.example.utsmobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*

class FishActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fishlist : ArrayList<FishFirebase>
    private lateinit var myadapter : FishAdapter
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish)

        recyclerView = findViewById(R.id.recycleviewuser)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        fishlist = arrayListOf()

        myadapter = FishAdapter(fishlist)

        recyclerView.adapter = myadapter

        DataListener()
    }

    private fun DataListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("ikan").
        addSnapshotListener(object : EventListener<QuerySnapshot>{
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if(error!=null)
                {
                    Log.e("Terjadi Error", error.message.toString())
                    return
                }
                for(doc : DocumentChange in value?.documentChanges!!){
                    if(doc.type == DocumentChange.Type.ADDED){
                        fishlist.add(doc.document.toObject(FishFirebase::class.java))
                    }
                }
                myadapter.notifyDataSetChanged()
        }
        })
    }
}
