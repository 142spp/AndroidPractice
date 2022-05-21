package com.example.week8_1

import android.app.DownloadManager
import android.content.IntentFilter
import android.graphics.pdf.PdfDocument
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //------------------------------------------------------------------
        val backgroundScope = CoroutineScope(Dispatchers.Default + Job())
        backgroundScope.launch {
            delay(1000)
            var time - masureTimeMillis {
                for( i in 1..2_000_000_000){
                    sum += i
                    channel.send(sum.toInt()))
                }
            }
        }
        val mainScope = GlobalScope.launch(Dispatcher.Main) {
            channer.consumeEach {
                binding.resultView.text = "sum : $it"
            }
        }

        //------------------------------------------------------------------

        var url =
            MyApplication.BASE_URL + "/v2/everything?q=${MyApplication.QUERY}&apikey=${MyApplication,API_KEY}&pag"

        val queue = Volley.newRequestQueue(activity)
        val jsonRequest =
            object : JsonObjecRequest (
                Request.Method.GET,
                url,
                null,
                Response.Listener<JSONObject> { response ->
                    val jsonArray = response.getJSONArray("articles")
                    val mutableList = mutableListOf<ItemModel>()
                    for(i in 0 until jsonArray.length()){
                        ItemModel().run {
                            val article = jsonArray.getJSONObject(i)
                            author = articlle.getString("author")
                            title  = article.getString("title")
                            description = article.getString("description")
                            urlToImage=article.getString("urlToImage")
                            publishedAt=article.getString("publisheAt")
                            mutableList.add(this)
                        }
                    }
                    binding.volleyRecyclerView.layoutManager=LinearLayoutManager(activity)
                    binding.volletRecyclerView.adapter=MyAdapter(activity as Context,mutableList)
                },
                Response.ErrorListener { error -> println("error..........$error")}){
                    override fun getHeaders(): MutableMap<String,String> {
                        val map = mutableMapOf<String,String>(
                            "User-agent" to MyApplication.USER_AGENT
                            )
                        return map
                    }
                }
        queue.add(jsonRequest)
        return binding.root

        //------------------------------------------------------------------

        val retrofit : Retrofit
            get() = Rtrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        interface NetWorkService {
            @GET("/v2/everything")
            fun getList(
                @Query("q") q: String?,
                @Query("apikey") apiKey : String?,
                @Query("page") page: Long,
                @Query("pageSize") pageSize : Int
            ) : Call<PageListModel>
        }

        class PageListModel {
            var articles : MutableList<ItemModel>? =null
        }

        val call:Call<PageListModel> = MyApplication.networkService.getList(
            MyApplication.QUERY,
            MyApplication.API_KEY,
            1,
            10
        )

        call?.enqueue(object : Callback<PageListModel> {
            override fun onResponse(
                call:Call<PageListModel>,
                response: Response<PageListModel>
            ) {
                if(response.isSuccessful()){
                    binding.retrofitRecyclerView.layoutManager=LinearLayoutManager(activity)
                    binding.retrofitRecyclerView.adapter=MyAdapter(activity as Context, response.body()?.articles)
                }
            }
        })

        //------------------------------------------------------------------

        val intentFilter = IntentFilter()
        intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        intentFilter.addAction(DownloadManager.ACTION_NOTIFICATION_CLICKED)
        registerReceiver(onDownloadComplete,intentFilter)

        val downloadUrl = "https://cse.pusan.ac.kr/sites/cse/download/cse_newsletter_vol_13_1.pdf"
        val request = DownloadManager.Request(Uri.parse(downloadUrl))
            .setTitle("Downloading a file")
            .setDescription("Downloading CSE Nesletter")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            .setDestinationUri(Uri.fromFile(file))
            .setRequiresCharging(false)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)

        downloadId = downloadManager.enqueue(request)

        private val onDownloadComplete = object : BroadcastReceiver() {
            override fun onReceive(context : Context, intent : Intent){
        }

        //------------------------------------------------------------------

    }
}