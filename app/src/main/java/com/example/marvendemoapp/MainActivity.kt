package com.example.marvendemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RestrictTo.Scope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvendemoapp.Model.TmdbData
import com.example.marvendemoapp.Service.ApiClient
import retrofit2.*
import java.security.Key

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewTop:RecyclerView
    private lateinit var recyclerViewUpcoming:RecyclerView
    lateinit var rvAdapter:AdapterClass
    lateinit var rv2Adapter:TopAdapterClass
    lateinit var rv3Adapter:UpcomingAdapterClass
    var results= mutableListOf<Result>()
    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.popularRecycler)
        recyclerViewTop = findViewById(R.id.TopRatedRecyclerView)
        recyclerViewUpcoming =findViewById(R.id.upComingRecyclerView)
       setAdapter()
        setAdapter2()
        setAdapter3()

    }
        private  fun fetchMovie() {
            val apiInterface = RetrofitInstance.apiClient.create(ApiClient::class.java)
         apiInterface.getMovie(Constants.API_KEY,20).enqueue(object : Callback<PopularMovies?> {
             override fun onResponse(
                 call: Call<PopularMovies?>,
                 response: Response<PopularMovies?>
             ) {
                 if (response.isSuccessful && response.body()!!.results != null) {
//                            //results.add(response.body()!!.results)
                            results.addAll(response.body()!!.results)
                          rvAdapter = this@MainActivity?.let { AdapterClass(results) }!!
                          recyclerView.adapter = rvAdapter
                           rvAdapter.notifyDataSetChanged()
                       } else {
                           Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()
                        }
             }
             override fun onFailure(call: Call<PopularMovies?>, t: Throwable) {
                 Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()
             }
         })
        }

    private  fun setAdapter(){
       recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
     fetchMovie()
    }
    private fun fetchTopRatedMovies(){
        val apiInterface=TopNewsRetrofitInstance.apiClient.create(ApiClient::class.java)
        apiInterface.getTopMovie(Constants.API_KEY,20).enqueue(object : Callback<PopularMovies?> {
            override fun onResponse(
                call: Call<PopularMovies?>,
                response: Response<PopularMovies?>
            ) {
                if (response.isSuccessful && response.body()!!.results!=null)
                    results.addAll(response.body()!!.results)
                rv2Adapter = this@MainActivity?.let { TopAdapterClass(results) }!!
                recyclerViewTop.adapter=rv2Adapter
                rv2Adapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<PopularMovies?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()

            }
        })
    }
    private fun setAdapter2(){
        recyclerViewTop.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
       fetchTopRatedMovies()
    }
    private fun fetchUpcomingMovies()
    {
        val apiInterface = RetrofitInstance.apiClient.create(ApiClient::class.java)
        apiInterface.upcomingMovie(Constants.API_KEY,20).enqueue(object : Callback<PopularMovies?> {
            override fun onResponse(
                call: Call<PopularMovies?>,
                response: Response<PopularMovies?>
            ) {
                if (response.isSuccessful && response.body()!!.results!=null)
                    results.addAll(response.body()!!.results)
                rv3Adapter = this@MainActivity?.let { UpcomingAdapterClass(results) }!!
                recyclerViewUpcoming.adapter=rv3Adapter
                rv3Adapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<PopularMovies?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()
            }
        })

    }
    private fun setAdapter3(){
        recyclerViewUpcoming.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        fetchUpcomingMovies()
    }

}


