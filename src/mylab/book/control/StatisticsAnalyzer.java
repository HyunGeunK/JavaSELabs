package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    // 헬퍼 메서드: 출판물 타입을 문자열로 반환
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    // 타입별 평균 가격 계산
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> priceSum = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            priceSum.put(type, priceSum.getOrDefault(type, 0) + pub.getPrice());
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> averagePrices = new HashMap<>();
        for (String type : priceSum.keySet()) {
            averagePrices.put(type, (double) priceSum.get(type) / count.get(type));
        }
        return averagePrices;
    }

    // 출판물 유형 분포 계산
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> count = new HashMap<>();
        int total = publications.length;

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        for (String type : count.keySet()) {
            distribution.put(type, (double) count.get(type) * 100 / total);
        }
        return distribution;
    }

    // 특정 연도 출판물 비율 계산
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (double) count * 100 / publications.length;
    }

    // 모든 통계 출력
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###");
        DecimalFormat dfPercent = new DecimalFormat("0.00");

        System.out.println("===== 출판물 통계 분석 =====");
        
        // 1. 타입별 평균 가격
        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + df.format(entry.getValue()) + "원");
        }
        System.out.println();

        // 2. 출판물 유형 분포
        System.out.println("2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + dfPercent.format(entry.getValue()) + "%");
        }
        System.out.println();

        // 3. 2007년 출판물 비율
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("3. 2007년에 출판된 출판물 비율: " + dfPercent.format(ratio2007) + "%");
    }
}