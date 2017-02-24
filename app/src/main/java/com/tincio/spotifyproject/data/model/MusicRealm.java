
package com.tincio.spotifyproject.data.model;


public class MusicRealm {//extends RealmObject{

    private Integer id;
    private Boolean favorite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
}
