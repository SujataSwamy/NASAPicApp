package com.nasa.nasapicapp.data;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/*
NasaImage Json Pojo class
 */
public class NasaImage
{
    private String date;

    private String copyright;

    private String media_type;

    private String hdurl;

    private String service_version;

    private String explanation;

    private String title;

    private String url;

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getCopyright ()
    {
        return copyright;
    }

    public void setCopyright (String copyright)
    {
        this.copyright = copyright;
    }

    public String getMedia_type ()
    {
        return media_type;
    }

    public void setMedia_type (String media_type)
    {
        this.media_type = media_type;
    }

    public String getHdurl ()
    {
        return hdurl;
    }

    public void setHdurl (String hdurl)
    {
        this.hdurl = hdurl;
    }

    public String getService_version ()
    {
        return service_version;
    }

    public void setService_version (String service_version)
    {
        this.service_version = service_version;
    }

    public String getExplanation ()
    {
        return explanation;
    }

    public void setExplanation (String explanation)
    {
        this.explanation = explanation;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date = "+date+", copyright = "+copyright+", media_type = "+media_type+", hdurl = "+hdurl+", service_version = "+service_version+", explanation = "+explanation+", title = "+title+", url = "+url+"]";
    }

    @BindingAdapter("profileImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl).apply(new RequestOptions().centerInside())
                .into(view);
    }
}

