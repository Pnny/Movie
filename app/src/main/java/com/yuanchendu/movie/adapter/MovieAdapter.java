package com.yuanchendu.movie.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuanchendu.movie.R;
import com.yuanchendu.movie.bean.MovieBean;

import java.util.List;

/**
 * Created by Reims on 2016/11/29.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    private List<MovieBean> movieBeans;
    public ItemClickListener mListener;

    public MovieAdapter(List<MovieBean> movieBeans) {
        this.movieBeans = movieBeans;
    }

    public void setOnItemClickListener(ItemClickListener listener){
        mListener = listener;
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.name.setText(movieBeans.get(position).getName());
        holder.cast.setText(movieBeans.get(position).getCast());
        holder.description.setText(movieBeans.get(position).getdescription());
        holder.hasSeen.setText(movieBeans.get(position).getHaveSeen());
        holder.rate.setText(movieBeans.get(position).getRate());
        holder.genre.setText(movieBeans.get(position).getGenre());
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        return new MovieViewHolder(view,mListener);

    }

    @Override
    public int getItemCount() {
        return movieBeans == null ? 0 : movieBeans.size() ;
    }



    /**
     * ViewHolder
     */
    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name;
        private TextView cast;
        private TextView hasSeen;
        private TextView rate;
        private TextView description;
        private TextView genre;
        private ItemClickListener mListener;

        public MovieViewHolder(View itemView,ItemClickListener listener) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.movie_name);
            cast = (TextView)itemView.findViewById(R.id.movie_cast);
            hasSeen = (TextView)itemView.findViewById(R.id.movie_has_seen);
            rate = (TextView)itemView.findViewById(R.id.movie_rate);
            description = (TextView)itemView.findViewById(R.id.movie_description);
            genre = (TextView)itemView.findViewById(R.id.movie_genre);
            mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(v, getPosition());
            }
        }

    }


    /**
     * 点击事件接口
     */
    public interface ItemClickListener {
        public void onItemClick(View view, int position);
    }
}
