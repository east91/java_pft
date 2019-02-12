package com.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  private final String id;
  private final String name;
  private final String header;
  private final String footer;

  public GroupData(String id,String name, String header, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public GroupData(String name, String header, String footer) {
    this.id = null;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    if (id != null ? !id.equals(groupData.id) : groupData.id != null) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override    // this method need to be overwritten --> see lessons video.   (commented code below is auto generated methods)
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return Objects.hash(id, name);
  }

  /*@Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(id, groupData.id) &&
            Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }*/

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

}
