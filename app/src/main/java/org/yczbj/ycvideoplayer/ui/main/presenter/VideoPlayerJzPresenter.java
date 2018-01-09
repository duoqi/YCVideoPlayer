package org.yczbj.ycvideoplayer.ui.main.presenter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import org.yczbj.ycvideoplayer.R;
import org.yczbj.ycvideoplayer.ui.main.contract.VideoPlayerJzContract;
import org.yczbj.ycvideoplayer.ui.main.contract.VideoPlayerMeContract;
import org.yczbj.ycvideoplayer.ui.main.model.VideoPlayerComment;

import java.util.ArrayList;
import java.util.List;

import rx.subscriptions.CompositeSubscription;


/**
 * ================================================
 * 作    者：杨充
 * 版    本：1.0
 * 创建日期：2017/3/18
 * 描    述：Main主页面
 * 修订历史：
 * ================================================
 */
public class VideoPlayerJzPresenter implements VideoPlayerJzContract.Presenter {

    private VideoPlayerJzContract.View mView;
    private CompositeSubscription mSubscriptions;
    private Activity activity;

    public VideoPlayerJzPresenter(VideoPlayerJzContract.View androidView) {
        this.mView = androidView;
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void subscribe() {

    }


    @Override
    public void unSubscribe() {
        mSubscriptions.clear();
        if(activity!=null){
            activity = null;
        }
    }


    @Override
    public void bindView(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void getData() {
        List<VideoPlayerComment> comments = new ArrayList<>();
        for(int a=0 ; a<20 ; a++){
            VideoPlayerComment videoPlayerComment = new VideoPlayerComment(
                    R.drawable.battery_10,"潇湘剑雨",5,"这个仿优酷视频Ui太好呢");
            comments.add(videoPlayerComment);
        }
        mView.setAdapterView(comments);
    }
}
