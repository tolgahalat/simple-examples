package tolgstoy;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        // Bir Flux oluşturun: 1'den 10'a kadar tam sayılar
        Flux<Integer> numbersFlux = Flux.range(1, 10);

        numbersFlux
                .map(i -> {
                    if (i == 5) { // 5 sayısında bir hata tetikleyelim
                        throw new RuntimeException("Beklenen bir hata oluştu: " + i);
                    }
                    return i * 2; // Kalan sayıları 2 ile çarp
                })
                .onErrorResume(e -> { // Hata yönetimi
                    System.out.println("Hata yakalandı: " + e.getMessage());
                    return Flux.just(-1); // Hata durumunda -1 dön
                })
                .subscribe(
                        result -> System.out.println("Sonuç: " + result), // Her sonuç için yazdır
                        error -> System.err.println("Akışta bir hata oluştu: " + error), // Tüm hata yönetimi
                        () -> System.out.println("Akış tamamlandı!") // Akış tamamlandığında yazdır
                );
    }
}