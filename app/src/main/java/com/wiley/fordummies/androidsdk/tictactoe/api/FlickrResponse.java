package com.wiley.fordummies.androidsdk.tictactoe.api;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class FlickrResponse {

	@SerializedName("photos")
	public PhotoResponse mPhotos;

	public FlickrResponse() {
		mPhotos = new PhotoResponse();
	}

	public FlickrResponse(PhotoResponse photos) {
		mPhotos = photos;
	}

	public PhotoResponse getPhotos() {
		return mPhotos;
	}

	public void setPhotos(PhotoResponse photos) {
		this.mPhotos = photos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FlickrResponse that = (FlickrResponse) o;
		return mPhotos.equals(that.mPhotos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mPhotos);
	}

	@Override
	@NonNull
	public String toString() {
		return "FlickrResponse: {" + mPhotos + "}";
	}
}
