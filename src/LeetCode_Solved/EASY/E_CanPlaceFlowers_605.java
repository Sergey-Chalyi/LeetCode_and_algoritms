package LeetCode_Solved.EASY;
// 09-06-2024
public class E_CanPlaceFlowers_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // проверяем слачай, когда на клумбе 1 место
        if (flowerbed.length == 1 && flowerbed[0] == 0)  return 1 >= n;

        // проверяем случай, если на клумбе все места пустые
        int countOfZeroes = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) countOfZeroes++;
        }
            // важно: к-во свободных мест будет разным в зависимости от того, оно четное, ил не четное
        if (countOfZeroes == flowerbed.length) return (countOfZeroes % 2 == 0 ? countOfZeroes / 2 : countOfZeroes / 2 + 1) >= n;

        // во всех других случаях у нас другой алгоритм
        boolean flag = false; // флаг нужен, чтоб мы отмечали: есть ли в начале / в конце область с пустыми местами
        int finalCount = 0; // к-во мест, куда можно посадить
        for(int i = 0; i < flowerbed.length; /**/) { // !!! важно: автоматом переменную в цикле НЕ увеличиваем
            // когда находим начало свободной области начинаем внутренний цикл
            if (flowerbed[i] == 0) {
                int countOfPlaces = 0; // к-во свободных мест в данной области
                for(/**/; i < flowerbed.length; i++) { // !!! важно: продолжаем работать с переменной из внешнего цикла
                    if ((i == 0 && flowerbed[i] == 0) || (i == flowerbed.length - 1 && flowerbed[i] == 0)) flag = true; // устанавливаем флаг

                    if (flowerbed[i] == 0) countOfPlaces++; // ведем подсчет к-во свободных мест в этой области
                    else break; // когда доходим до конца пустой зоны, выходим из внутреннего цикла
                }
                // на выходе получаем число - сколько у нас на данном участке пустых мест
                if (flag == true) { // если у нас данный отрезок - начальный, или конечный, то подсчет мест, куда можно сажать, будет происходить чуток по другому
                    finalCount += countOfPlaces / 2;
                    flag = false; // !!! НЕ забываем СНЯТЬ флаг
                } else { // а если отрезок не начальный и не конечный, то считаем вот так
                    finalCount += (countOfPlaces % 2 == 0 ? countOfPlaces / 2 - 1 : countOfPlaces / 2);
                }

            } else { // если данной место - не начало пустой зоны, то увеличиваем переменную цикла, чтоб не застрячь в бесконечном цикле
                i++;
            }
        }
        // когда окончили цикл, то возвращаем финальный результат
        return finalCount >= n;
    }
}
