package Vani;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Post");
            System.out.println("2. Fetch All Post");
            System.out.println("3. Delete post");
            System.out.println("4. Update Post Privacy");
            System.out.println("5. Log Event");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Post ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("User Id: ");
                    int id2 = scanner.nextInt();
                    System.out.print("Content: ");
                    String content = scanner.next();
                    System.out.print("Timestamp: ");
                    String timestamp = scanner.next();
                    System.out.print("Privacy: ");
                    String privacy = scanner.next();
                   Post post = new Post(id, id2, content, timestamp, privacy);
                    PostManager.addPost(post);
                    break;

                case 2:
                    PostManager.fetchAllPosts();
                    break;

                case 3:
                    System.out.print("Post ID to delete: ");
                    int deleteId = scanner.nextInt();
                    PostManager.deletePost(deleteId);
                    break;

                case 4:
                    System.out.print("Post ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New privacy: ");
                    String pri = scanner.nextLine();
                    PostManager.updatePost(updateId, pri);
                    break;

                case 5:
                    System.out.print("Enter event to log: ");
                    String event = scanner.nextLine();
                    PostLogger.logEvent(event);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
