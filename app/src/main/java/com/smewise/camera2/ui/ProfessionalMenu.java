package com.smewise.camera2.ui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.smewise.camera2.Config;
import com.smewise.camera2.data.CamListPreference;
import com.smewise.camera2.data.PrefListAdapter;
import com.smewise.camera2.utils.XmlInflater;

/**
 * Created by wenzhe on 11/27/17.
 */

public class ProfessionalMenu extends CameraBaseMenu {

    public static final String TAG = Config.getTag(ProfessionalMenu.class);
    private Context mContext;
    private OnMenuClickListener mMenuClickListener;
    private PrefListAdapter mAdapter;

    public ProfessionalMenu(Context context, int resId) {
        super(context);
        mContext = context;
        XmlInflater xmlInflater = new XmlInflater(context);
        mAdapter = new PrefListAdapter(context, xmlInflater.inflate(resId));
        mAdapter.setClickListener(mMenuListener);
        recycleView.setAdapter(mAdapter);
        recycleView.setBackgroundColor(0x77000000);
    }

    public View getView() {
        return recycleView;
    }

    public void setOnMenuClickListener(OnMenuClickListener listener) {
        mMenuClickListener = listener;
    }

    /**
     * Camera menu click listener
     */
    private PrefListAdapter.PrefClickListener mMenuListener =
            new PrefListAdapter.PrefClickListener() {
        @Override
        public void onClick(View view, int position, CamListPreference preference) {
            Log.i(TAG, "onClick:" + preference.getKey());
            if (mMenuClickListener != null) {
                mMenuClickListener.onMenuClick(preference.getKey(), null);
            }
        }
    };


}