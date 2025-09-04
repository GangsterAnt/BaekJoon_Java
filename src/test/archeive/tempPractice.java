package test.archeive;

import java.util.*;
import java.util.stream.Collectors;

public class tempPractice {

    public static void main(String[] args) {
        String versionString1 = "1.1.1";
        String versionString2 = "5.1.2";
        String versionString3 = "2.1.2";

        Version version1 = new Version(versionString1);
        Version version2 = new Version(versionString2);
        Version version3 = new Version(versionString3);

        List<Version> versionList = new ArrayList<>();
        versionList.add(version1);
        versionList.add(version2);
        versionList.add(version3);

        //람다를 이용한 구현 - 비효율
        List<Version> collectV1 = versionList.stream()
                .sorted(Comparator.comparing((Version v) -> v.major)
                        .reversed()
                        .thenComparing((Version v) -> v.minor)
                        .reversed()
                        .thenComparing((Version v) -> v.release)
                        .reversed()
                )
                .collect(Collectors.toList());

        //람다를 이용한 구현 - 비교적 효율
        List<Version> collectV1_2 = versionList.stream()
                .sorted(Comparator.comparing((Version v) -> -v.major)
                        .thenComparing((Version v) -> -v.minor)
                        .thenComparing((Version v) -> -v.release)
                )
                .collect(Collectors.toList());

        // 내부 compareTo를 구현함으로써 간결화
        List<Version> collectV2 = versionList.stream()
                .sorted()
                .collect(Collectors.toList());

        PriorityQueue<Version> pqWithComparable = new PriorityQueue<>();
        pqWithComparable.add(version1);
        pqWithComparable.add(version2);
        pqWithComparable.add(version3);

        Version poll = pqWithComparable.poll();

        VersionComparator comparator = new VersionComparator();
        PriorityQueue<Version> pqWithComparator = new PriorityQueue<>(comparator);
        pqWithComparator.add(version1);
        pqWithComparator.add(version2);
        pqWithComparator.add(version3);
        Version poll1 = pqWithComparator.poll();

        System.out.println("Latest version in V1 is.." + collectV1.get(0).major + "." + collectV1.get(0).minor +"." +collectV1.get(0).release);
        System.out.println("Latest version in V1-2 is.." + collectV1_2.get(0).major + "." + collectV1_2.get(0).minor +"." +collectV1_2.get(0).release);
        System.out.println("Latest version in V2 is.." + collectV2.get(0).major + "." + collectV2.get(0).minor +"." +collectV2.get(0).release);
        System.out.println("Latest version in Pq with comparable is.." + poll.major + "." + poll.minor +"." +poll.release);
        System.out.println("Latest version in Pq with comparator is.." + poll1.major + "." + poll1.minor +"." +poll1.release);

    }

    public static class Version implements Comparable<Version> {
        public int major;
        public int minor;
        public int release;

        public Version(int major, int minor, int release) {
            this.major = major;
            this.minor = minor;
            this.release = release;
        }

        public Version(String version) {
            String[] versionList = version.split("\\.");

            this.major = Integer.parseInt(versionList[0]);
            this.minor = Integer.parseInt(versionList[1]);
            this.release = Integer.parseInt(versionList[2]);
        }

        @Override
        public int compareTo(Version other) {
            // 내림차순을 위해 other와 this의 순서를 바꿔서 비교
            if (other.major != this.major) {
                return Integer.compare(other.major, this.major);
            }
            if (other.minor != this.minor) {
                return Integer.compare(other.minor, this.minor);
            }
            return Integer.compare(other.release, this.release);
        }

        }
    public static class VersionComparator implements Comparator<tempPractice.Version> {
        @Override
        public int compare(tempPractice.Version v1, tempPractice.Version v2) {
            // 두 객체를 외부에서 비교하는 방법을 정의
            if (v1.major != v2.major) {
                return Integer.compare(v2.major, v1.major);
            }
            if (v2.minor != v1.minor) {
                return Integer.compare(v2.minor, v1.minor);
            }
            return Integer.compare(v2.release, v1.release);
        }
    }
}
