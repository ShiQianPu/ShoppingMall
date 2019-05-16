package shiqianpu.baway.com.shoppingmall.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import shiqianpu.baway.com.shoppingmall.R;

public class MovieHolder extends RecyclerView.ViewHolder {
    public final ImageView img;
    public final TextView ttt;
    public MovieHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        ttt = itemView.findViewById(R.id.ttt);
    }
}
