package ini.punya.rustandy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.azhar.spks.R;
import ini.punya.rustandy.activities.DetailPenyakitActivity;
import ini.punya.rustandy.model.ModelDaftarPenyakit;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

/**
 * Created by Rustandy Muslim on 10-01-2024
 * Github : https://github.com/rustandimuslim
 * Instagram : https://www.instagram.com/rstndy_00
 */

public class DaftarPenyakitAdapter extends RecyclerView.Adapter<DaftarPenyakitAdapter.DaftarPenyakitHolder> {

    private Context ctx;
    private ArrayList<ModelDaftarPenyakit> modelDaftarPenyakitArrayList;

    public DaftarPenyakitAdapter(Context context, ArrayList<ModelDaftarPenyakit> items) {
        this.ctx = context;
        this.modelDaftarPenyakitArrayList = items;
    }

    @Override
    public DaftarPenyakitAdapter.DaftarPenyakitHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_kerusakan, parent, false);
        return new DaftarPenyakitHolder(view);
    }

    @Override
    public void onBindViewHolder(DaftarPenyakitAdapter.DaftarPenyakitHolder holder, final int position) {
        final ModelDaftarPenyakit data = modelDaftarPenyakitArrayList.get(position);

        holder.tvKodePenyakit.setText(data.getStrKode());
        holder.tvNamaPenyakit.setText(data.getStrDaftarPenyakit());

        holder.cvListData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctx.startActivity(new Intent(ctx, DetailPenyakitActivity.class)
                        .putExtra("KODE_PENYAKIT", data.getStrKode()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelDaftarPenyakitArrayList.size();
    }

    static class DaftarPenyakitHolder extends RecyclerView.ViewHolder {
        public MaterialCardView cvListData;
        public TextView tvKodePenyakit;
        public TextView tvNamaPenyakit;

        public DaftarPenyakitHolder(View itemView) {
            super(itemView);
            cvListData = itemView.findViewById(R.id.cvListData);
            tvKodePenyakit = itemView.findViewById(R.id.tvKodePenyakit);
            tvNamaPenyakit = itemView.findViewById(R.id.tvNamaPenyakit);
        }
    }

}