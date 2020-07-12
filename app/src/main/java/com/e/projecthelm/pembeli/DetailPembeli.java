package com.e.projecthelm.pembeli;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.e.projecthelm.R;
import com.e.projecthelm.server.BaseURL;
import com.squareup.picasso.Picasso;

public class DetailPembeli extends AppCompatActivity {

    EditText edtKodeHelm, edtTipeHelm, edtJenisHelm, edtMerkHelm, edtHargaHelm;
    ImageView imgGambarHelm;

    String strKodeHelm, strTipeHelm, strJenisHelm, strMerkHelm, strHargaHelm, strGamabr, _id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pembeli);

        edtKodeHelm = (EditText) findViewById(R.id.edtKodeHelm);
        edtTipeHelm = (EditText) findViewById(R.id.edtTipeHelm);
        edtJenisHelm = (EditText) findViewById(R.id.edtJenisHelm);
        edtMerkHelm = (EditText) findViewById(R.id.edtMerkHelm);
        edtHargaHelm = (EditText) findViewById(R.id.edtHargaHelm);

        imgGambarHelm = (ImageView) findViewById(R.id.gambar);

        Intent i = getIntent();
        strKodeHelm= i.getStringExtra("kodeHelm");
        strTipeHelm = i.getStringExtra("tipeHelm");
        strJenisHelm = i.getStringExtra("jenisHelm");
        strMerkHelm = i.getStringExtra("merkHelm");
        strHargaHelm = i.getStringExtra("hargaHelm");
        strGamabr = i.getStringExtra("gambar");
        _id = i.getStringExtra("_id");

        edtKodeHelm.setText(strKodeHelm);
        edtTipeHelm.setText(strTipeHelm);
        edtJenisHelm.setText(strJenisHelm);
        edtMerkHelm.setText(strMerkHelm);
        edtHargaHelm.setText(strHargaHelm);
        Picasso.get().load(BaseURL.baseUrl + "gambar/" + strGamabr)
                .into(imgGambarHelm);
    }
}
