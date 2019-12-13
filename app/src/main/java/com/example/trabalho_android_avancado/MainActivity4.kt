package com.example.trabalho_android_avancado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main4.*
import java.net.URL
import java.util.Observer


class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

     }

  /*
    override fun onResume() {

        super.onResume()
        button1ACTM4.setOnClickListener {
            val workManager = WorkManager.getInstance()
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED).build()

            val inputData = Data.Builder()
                .putString("url",
                    "https://newsapi.org/v2/everything?q=bitcoin&apiKey=API_KEY").build()

            val oneTimeWorkRequest= OneTimeWorkRequest.Builder(doWork::class.java)
                .setConstraints(constraints).setInputData(inputData).build()

            workManager.enqueue(oneTimeWorkRequest)

            workManager.getWorkInfoByIdLiveData(oneTimeWorkRequest.id).
                observe(this, Observer { workInfo ->
                    if(workInfo!=null && workInfo.state.isFinished){
                        textView2.text = workInfo.outputData.getString("json")
                    }
                })
        }
    }
*/
}

