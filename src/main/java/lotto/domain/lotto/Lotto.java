package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.validation.lotto.LottoRuleRegistry;
import lotto.domain.validation.lotto.LottoValidator;
import lotto.domain.validation.lotto.input.LottoValidationRule;

public class Lotto {

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers, LottoValidator validator) {
        this.numbers = numbers;
        validator.validate(numbers);
    }

    //Controller의 책임 해소와 test코드를 위한 메서드
    public static Lotto create(List<LottoNumber> numbers) {
        List<LottoValidationRule> rules = LottoRuleRegistry.getLottoRules();
        LottoValidator lottoValidator = new LottoValidator(rules);
        new Lotto(numbers, lottoValidator);
        return new Lotto(numbers, lottoValidator);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto winningNumber) {
        int matchCount = 0;
        Set<LottoNumber> winningSet = new HashSet<>(winningNumber.numbers);
        for (LottoNumber number : numbers) {
            if (winningSet.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public List<LottoNumber> getSortedNumbers() {
        List<LottoNumber> sortedNumbers = new ArrayList<>(this.numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    @Override
    public String toString() {
        List<Integer> integerNumbers = getSortedNumbers().stream()
                .map(LottoNumber::getLottoNumber)
                .toList();
        return integerNumbers.toString();
    }
}

