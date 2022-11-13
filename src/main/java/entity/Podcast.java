package entity;

import java.sql.Date;

public class Podcast {
 int podcastId;
 String naam;
 String celeb;
 String genre;
 Date date;
 String url;

 public Podcast(int podcastId, String naam, String celeb, String genre, Date date, String url) {
  this.podcastId = podcastId;
  this.naam = naam;
  this.celeb = celeb;
  this.genre = genre;
  this.date = date;
  this.url = url;
 }

 public int getPodcastId() {
  return podcastId;
 }

 public void setPodcastId(int podcastId) {
  this.podcastId = podcastId;
 }

 public String getNaam() {
  return naam;
 }

 public void setNaam(String naam) {
  this.naam = naam;
 }

 public String getCeleb() {
  return celeb;
 }

 public void setCeleb(String celeb) {
  this.celeb = celeb;
 }

 public String getGenre() {
  return genre;
 }

 public void setGenre(String genre) {
  this.genre = genre;
 }

 public Date getDate() {
  return date;
 }

 public void setDate(Date date) {
  this.date = date;
 }

 public String getUrl() {
  return url;
 }

 public void setUrl(String url) {
  this.url = url;
 }

 @Override
 public String toString() {
  return "Podcast{" +
          "podcastId=" + podcastId +
          ", naam='" + naam + '\'' +
          ", celeb='" + celeb + '\'' +
          ", genre='" + genre + '\'' +
          ", date=" + date +
          ", url='" + url + '\'' +
          '}';
 }
}
