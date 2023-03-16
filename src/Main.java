//https://www.acmicpc.net/problem/1004

//문제 포인트 1. 원들안에 점P,Q가 있는지를 판별해라

//문제 포인트 2. 만약 두 점이 같은 원안에 존재한다면 진입/탈출이 이루어지지 않으므로 카운트되지 않는다.

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SimpleTimeZone;

//문제 포인트 3. 원과 점 p,q포함여부를 갖는 객체를 만들어 둘중 하나만 포함하고 있는 객체의 수를 구하면 된다.
public class Main {
    //0번 인덱스는 x좌표, 1번 인덱스는 y좌표, 2번 인덱스는 반지름입니다.
    int[] p = {0, 0};
    int[] q = {0, 0};

    double distance;
    double distanceP;
    double distanceQ;

    int[] circle = {0, 0, 0};

    boolean[] circleContainsDots = {false, false};

    void setDistance(int x1, int y1, int x2, int y2) {
        int x = x2 - x1;
        int y = y2 - y1;
        this.distance = Math.sqrt(x * x + y * y);
    }

    double getDistance() {
        return this.distance;
    }

    void setCircleContainsDots(int r, double distanceP, double distanceQ) {
        if (distanceP < r)
            this.circleContainsDots[0] = true;
        else
            this.circleContainsDots[0] = false;

        if (distanceQ < r)
            this.circleContainsDots[1] = true;
        else
            this.circleContainsDots[1] = false;

    }

    boolean[] getCircleContainsDots() {
        return this.circleContainsDots;
    }

    public static void main(String[] args) {

        ArrayList<Integer> answers = new ArrayList<Integer>();
        Main solve = new Main();


        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();//시행 테이스 케이스 횟수

        for (int i = 0; i < testCount; i++) {
            int answer = 0;
            //출발점, 도착점 정하기
            solve.p[0] = sc.nextInt();
            solve.p[1] = sc.nextInt();
            solve.q[0] = sc.nextInt();
            solve.q[1] = sc.nextInt();

            int circleNum = sc.nextInt();//행성계 개수

            //행성계 개수만큼 반복
            for (int j = 0; j < circleNum; j++) {

                //행성 좌표, 반지름 정하기
                solve.circle[0] = sc.nextInt();
                solve.circle[1] = sc.nextInt();
                solve.circle[2] = sc.nextInt();

                //p좌표와 행성의 거리구하기
                solve.setDistance(solve.p[0], solve.p[1], solve.circle[0], solve.circle[1]);
                solve.distanceP = solve.getDistance();

                //q좌표와 행성의 거리구하기
                solve.setDistance(solve.q[0], solve.q[1], solve.circle[0], solve.circle[1]);
                solve.distanceQ = solve.getDistance();

                //포함 여부 계산하기
                solve.setCircleContainsDots(solve.circle[2], solve.distanceP, solve.distanceQ);

                //XOR로 둘중 하나만 포함여부 구하기
                boolean hasP = solve.getCircleContainsDots()[0];
                boolean hasQ = solve.getCircleContainsDots()[1];
                if (hasP ^ hasQ)
                    answer++;
            }
            answers.add(answer);


        }


        for (int answer : answers) {
            System.out.println(answer);
        }

    }

}
