package com.keto.jangamelo;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.keto.jangamelo.Rajawali.RajawaliActivity;
import com.netease.pomelo.PomeloClient;

public class Main extends RajawaliActivity {

    private GLRenderer mRenderer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRenderer = new GLRenderer(this);
        mRenderer.setSurfaceView(mSurfaceView);
        super.setRenderer(mRenderer);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        PomeloClient client = new PomeloClient("jangadaserver.no-ip.info", 7070);
        client.init();

        //client.request(route, msg, new DataCallBack(){
            //public void responseData(JSONObject msg){
                //handle data here
            //}
        //});
        //client.inform(route, msg);
        //client.on(route, new DataListener(){
            //public void receiveData(DataEvent event){
                //JSONObject msg = event.getMessage();
                //handle data from server
            //}
        //});
        //client.disconnect();
    }

}
