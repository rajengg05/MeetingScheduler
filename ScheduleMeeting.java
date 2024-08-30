package MeetingScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScheduleMeeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example setup
        MeetingRoom room1 = new MeetingRoom("Room1");
        Participant alice = new Participant("Alice");
        Participant bob = new Participant("Bob");

        List<Participant> participants = new ArrayList<>();
        participants.add(alice);
        participants.add(bob);
        while(true) {
            System.out.println("Enter day:");
            String day = scanner.nextLine();

            System.out.println("Enter start time:");
            String startTime = scanner.nextLine();

            System.out.println("Enter end time:");
            String endTime = scanner.nextLine();

            Meeting meeting = new Meeting(day, startTime, endTime, room1, participants);

            Scheduler scheduler = new Scheduler();
            if (scheduler.canScheduleMeeting(meeting)) {
                scheduler.scheduleMeeting(meeting);
                System.out.println("Meeting scheduled successfully.");
            } else {
                System.out.println("Meeting cannot be scheduled due to conflicts.");
            }
            System.out.println("Do you want to schedule another meeting? (yes/no):");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }
}
