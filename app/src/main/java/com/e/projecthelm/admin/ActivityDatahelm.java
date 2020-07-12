package com.e.projecthelm.admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.e.projecthelm.R;
import com.e.projecthelm.adapter.Adapterhelm;
import com.e.projecthelm.model.Modelhelm;
import com.e.projecthelm.server.BaseURL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityDatahelm extends AppCompatActivity {

    ProgressDialog pDialog;

    Adapterhelm adapter;
    ListView list;

    ArrayList<Modelhelm> newsList = new ArrayList<Modelhelm>();
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_helm);

        getSupportActionBar().setTitle("Data Helm");
        mRequestQueue = Volley.newRequestQueue(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        list = (ListView) findViewById(R.id.array_list);
        newsList.clear();
        adapter = new Adapterhelm(ActivityDatahelm.this, newsList);
        list.setAdapter(adapter);
        getAllHelm();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ActivityDatahelm.this, HomeAdminActivity.class);
        startActivity(i);
        finish();
    }

    private void getAllHelm() {
        // Pass second argument as "null" for GET requests
        pDialog.setMessage("Loading");
        showDialog();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, BaseURL.dataHelm, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        hideDialog();
                        try {
                            boolean status = response.getBoolean("error");
                            if (status == false) {
                                Log.d("data helm = ", response.toString());
                                String data = response.getString("data");
                                JSONArray jsonArray = new JSONArray(data);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    final Modelhelm Helm = new Modelhelm();
                                    final String _id = jsonObject.getString("_id");
                                    final String kodeHelm = jsonObject.getString("kodeHelm");
                                    final String tipeHelm = jsonObject.getString("tipeHelm");
                                    final String jenisHelm = jsonObject.getString("jenisHelm");
                                    final String merkHelm = jsonObject.getString("merkHelm");
                                    final String hargaHelm = jsonObject.getString("hargaHelm");
                                    final String gamabr = jsonObject.getString("gambar");
                                    Helm.setKodeHelm(kodeHelm);
                                    Helm.setTipeHelm(tipeHelm);
                                    Helm.setJenisHelm(jenisHelm);
                                    Helm.setMerkHelm(merkHelm);
                                    Helm.setHargaHelm(hargaHelm);
                                    Helm.setGambar(gamabr);
                                    Helm.set_id(_id);

                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            // TODO Auto-generated method stub
                                            Intent a = new Intent(ActivityDatahelm.this, EditHelmDanHapusActivity.class);
                                            a.putExtra("kodeHelm", newsList.get(position).getKodeHelm());
                                            a.putExtra("_id", newsList.get(position).get_id());
                                            a.putExtra("tipeHelm", newsList.get(position).getTipeHelm());
                                            a.putExtra("jenisHelm", newsList.get(position).getJenisHelm());
                                            a.putExtra("merkHelm", newsList.get(position).getMerkHelm());
                                            a.putExtra("hargaHelm", newsList.get(position).getHargaHelm());
                                            a.putExtra("gambar", newsList.get(position).getGambar());
                                            startActivity(a);
                                        }
                                    });
                                    newsList.add(Helm);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                hideDialog();
            }
        });

        /* Add your Requests to the RequestQueue to execute */
        mRequestQueue.add(req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
