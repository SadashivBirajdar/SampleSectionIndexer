package example.com.samplesectionindexer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by emb-sadabir on 7/1/16.
 */
public class ContactsAdapter extends BaseAdapter implements SectionIndexer {

    Context context;
    List<String> mBrandNames;
    List<String> mSections;
    HashMap<String,Integer> mAlphaIndexer;


    public ContactsAdapter(Context context, List<String> names, HashMap<String, Integer> mAlphaIndexer) {
        this.context = context;
        this.mBrandNames = names;
        this.mAlphaIndexer = mAlphaIndexer;

        Set<String> sectionLetters = this.mAlphaIndexer.keySet();
        mSections= new ArrayList<>(sectionLetters);
        Collections.sort(mSections);
        Log.d("LOG","Sections: "+mSections);

    }

    @Override
    public int getCount() {
        return mBrandNames.size();
    }

    @Override
    public Object getItem(int position) {
        return mBrandNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.tv_contact);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(mBrandNames.get(position));

        return convertView;
    }

    @Override
    public Object[] getSections() {

        return mSections.toArray();
    }

    @Override
    public int getPositionForSection(int sectionIndex) {

        Log.d("LOG", "getPositionForSection: " + mAlphaIndexer.get(mSections.get(sectionIndex)));
        return mAlphaIndexer.get(mSections.get(sectionIndex));
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    static class ViewHolder {
        TextView text;
    }
}