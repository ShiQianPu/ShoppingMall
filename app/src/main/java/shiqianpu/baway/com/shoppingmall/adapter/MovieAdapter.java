package shiqianpu.baway.com.shoppingmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import shiqianpu.baway.com.shoppingmall.R;
import shiqianpu.baway.com.shoppingmall.bean.MovieBean;
import shiqianpu.baway.com.shoppingmall.holder.MovieHolder;

public class MovieAdapter extends RecyclerView.Adapter<MovieHolder> {
    private Context context;
   private List<MovieBean.ResultBean> datas;

    public MovieAdapter(Context context, List<MovieBean.ResultBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new MovieHolder(inflater.inflate(R.layout.item_list,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
        Glide.with(context).load(datas.get(i).getImageUrl()).into(movieHolder.img);
        movieHolder.ttt.setText(datas.get(i).getName());

    }
    @Override
    public int getItemCount() {
        return datas.size();
    }
}
