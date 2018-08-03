package com.berliner.stockworks.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    /*
     *Folder location for storing files
     * BEST PRACTICE: "In a production scenario, you more likely would store the files in a temporary location,
     * a database, or perhaps a NoSQL store like Mongo’s GridFS. It’s is best to NOT load up the file system of your application with content."
     * Source: https://spring.io/guides/gs/uploading-files/
     */

    private String location = "upload-dir";

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}
