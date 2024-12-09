package Vani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostManager {
    private static final String URL = "jdbc:mysql://localhost:3306/PostManagement?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ritankar123@@";

    // Add Post
    public static void addPost(Post Post) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String insertSQL = "INSERT INTO Post (PostId, UserId,  Post_Content, Timestamp,  Privacy) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, Post.get_post_id());
            pstmt.setInt(2, Post.getuser_id());
            pstmt.setString(3, Post.getContent());
            pstmt.setString(4, Post.gettimestamp());
            pstmt.setString(5, Post.getprivacy());
            pstmt.executeUpdate();
            System.out.println("Post added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    // Fetch All Posts
    public static void fetchAllPosts() {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String selectSQL = "SELECT * FROM Post";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectSQL);
            System.out.println("PostId\tUserId\tPost_Content\tTimestamp\tPrivacy");
            while (rs.next()) {
                int id1 = rs.getInt("PostId");
                int id2 = rs.getInt("UserId");
                String content = rs.getString("Post_Content");
                String time = rs.getString("Timestamp");
                String privacy = rs.getString("Privacy");
                System.out.printf("%d\t%d\t%s\t%s\t%s\n", id1, id2, content, time, privacy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Post
    public static void deletePost(int PostId) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String deleteSQL = "DELETE FROM Post WHERE PostId = ?";
            PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setInt(1, PostId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Post record deleted successfully.");
            } else {
                System.out.println("No Post found with the given ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Post Status
    public static void updatePost(int PostId, String privacy) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String updateSQL = "UPDATE Post SET privacy = ? WHERE PostId = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1, privacy);
            pstmt.setInt(2, PostId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Status updated successfully.");
            } else {
                System.out.println("No Post with this ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
