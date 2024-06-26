package recursions;

public class TowerHanoi {

    public void solution(int disk, String source, String middle, String destination) {

        if (disk == 1){
            // There is only one disk left on source, so will move to destination
            System.out.println("Moving disk " + disk + " from " + source+ " to " + destination);
            return;
        }

        // We are moving n - 1 disk to middle to be able to move the largest to destination
        // from : source = first to des = third, helper = second
        solution(disk - 1, source, destination, middle);
        // we call the method recursively so this is not always the largest plate
        System.out.println("Moving disk " + disk + " from " + source+ " to " + destination);

        // We move n - 1 disks from middle to destination with the help of source rod.
        // from : source = middle to des = first, helper = third
        solution(disk - 1, middle, source, destination);
    }

    public static void main(String[] args) {
        TowerHanoi hanoi = new TowerHanoi();
        hanoi.solution(16, "First", "Second", "Third");
    }
}
