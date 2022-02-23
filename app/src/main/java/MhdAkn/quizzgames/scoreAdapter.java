package MhdAkn.quizzgames;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class scoreAdapter extends BaseAdapter{

    private Context context;
    private List<Score> ScoreItemList;
    private LayoutInflater inflater;

    public scoreAdapter(Context context, List<Score> ScoreItemList) {
        this.context = context;
        this.ScoreItemList = ScoreItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ScoreItemList.size();
    }

    @Override
    public Score getItem(int position) {
        return ScoreItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapterlist, null);

        Score itemCourant = getItem(i);
        String itemName = itemCourant.getNom();
        String itemCateg = itemCourant.getCategorie();
        String itemSco= itemCourant.getScore();


        TextView textName = view.findViewById(R.id.playerName);
        textName.setText(itemName);

        TextView textCat = view.findViewById(R.id.cateName);
        textCat.setText(itemCateg);

        TextView textScore = view.findViewById(R.id.Score);
        textScore.setText(itemSco);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( context,ActivityList.class);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
