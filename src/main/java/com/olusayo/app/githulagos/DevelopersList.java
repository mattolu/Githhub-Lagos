package com.olusayo.app.githulagos;

/**
 * Created by OLUSAYO on 13-Sep-17.
 */

public class DevelopersList {
    private String login;
    private String avatar_url;
    private String html_url;

    /**
     * setting the getters and setters for  @params login, avatar_url and html_url
     * @return
     */
    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    /**
     * setting the constructor
     * @param login
     * @param gitUrl
     * @param avatar_url
     */
    public DevelopersList(String login, String gitUrl, String avatar_url) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = gitUrl;

    }
}
