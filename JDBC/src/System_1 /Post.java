package Vani;

public class Post {
    private int post_id;
    private int user_id;
    private String content;
    private String timestamp;
    private String privacy;

    // Constructor
    public Post(int post_id, int user_id, String content, String timestamp, String privacy) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.content = content;
        this.timestamp = timestamp;
        this.privacy = privacy;
    }

    // Getters and Setters
    public int get_post_id() {
        return post_id;
    }

    public void setpost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getuser_id() {
        return user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    public String gettimestamp() {
        return timestamp;
    }

    public void settimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getprivacy() {
        return privacy;
    }

    public void setStatus(String privacy) {
        this.privacy = privacy;
    }
    public void displayMissionDetails() {
        System.out.println("Post ID: " + post_id);
        System.out.println("User Id: " + user_id);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Content: " + content);
        System.out.println("Status: " + privacy);
    }

}

