package com.streamapi.warburton.chap09;

import com.streamapi.warburton.chap01.Artist;

import java.util.function.Function;

/**
 * Класс получает имена двух исполнителей, строит объекты Artist по именам
 * и возвращает true, если в первом исполнителе больше членов, чем во втором,
 * в противном случае возвращается false.
 * Через конструктор класса внедрена служба поиска исполнителей artistLookupService
 * На поиск у неё может уйти некоторое время.
 * Поскольку объект BlockingArtistAnalyzer два раза подряд блокирует выполнение
 * программы на время обращения к службе, он может работать медленно.
 * Задача в этом упражнении - повысить скорость, путем переработки
 * блокирующего кода возврата, воспользовавшись интерфейсом обратного вызова.
 * В данном случае он будет иметь тип {@literal Consumer<Boolean>}
 * Необходимо изменить класс BlockingArtistAnalyzer так,
 * чтобы он реализовывал интерфейс ArtistAnalyzer
 */
public class BlockingArtistAnalyzer {
  private final Function<String, Artist> artistLookupService;

  public BlockingArtistAnalyzer(Function<String, Artist> artistLookupService) {
    this.artistLookupService = artistLookupService;
  }

  public boolean isLargerGroup(String artistName, String otherArtistName) {
    return getNumberOfMembers(artistName) > getNumberOfMembers(otherArtistName);
  }

  private long getNumberOfMembers(String artistName) {
    return artistLookupService.apply(artistName).getMembers().count();
  }
}
