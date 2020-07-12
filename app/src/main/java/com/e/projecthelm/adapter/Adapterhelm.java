package com.e.projecthelm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.e.projecthelm.R;
import com.e.projecthelm.model.Modelhelm;
import com.e.projecthelm.server.BaseURL;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapterhelm extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Modelhelm> item;

    public Adapterhelm(Activity activity, List<Modelhelm> item) {
        this.activity = activity;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.content_helm, null);


        TextView kodeHelm = (TextView) convertView.findViewById(R.id.txtKodeHelm);
        TextView tipeHelm = (TextView) convertView.findViewById(R.id.txtTipeHelm);
        TextView jenisHelm = (TextView) convertView.findViewById(R.id.txtJenisHelm);
        TextView merkHelm  = (TextView) convertView.findViewById(R.id.txtMerkHelm);
        TextView hargaHelm = (TextView) convertView.findViewById(R.id.txtHargaHelm);
        ImageView gambarHelm = (ImageView) convertView.findViewById(R.id.gambarHelm);

        kodeHelm.setText(item.get(position).getKodeHelm());
        tipeHelm.setText(item.get(position).getTipeHelm());
        jenisHelm.setText(item.get(position).getJenisHelm());
        hargaHelm.setText("Rp." + item.get(position).getHargaHelm());
        merkHelm.setText(item.get(position).getMerkHelm());
        Picasso.get().load(BaseURL.baseUrl + "gambar/" + item.get(position).getGambar())
                .resize(40, 40)
                .centerCrop()
                .into(gambarHelm);
        return convertView;
    }

}