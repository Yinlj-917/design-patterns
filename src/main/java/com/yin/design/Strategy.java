package com.yin.design;

/**
 * @author lijian.yin@hand-china.com
 * @date 2018/10/28
 */
public interface Strategy {

    Double memberStrategy(Double d);


    static void main(String[] args) {
        Strategy strategy = new StrategyA();
        Price price = new Price(strategy);
        Double resultPrice = price.resultPrice(10d);
        System.out.println(resultPrice);
    }
}

class StrategyA implements  Strategy {

    @Override
    public Double memberStrategy(Double d) {
        return d * 0.8;
    }
}

class StrategyB implements  Strategy {

    @Override
    public Double memberStrategy(Double d) {
        return d * 0.7;
    }
}

class Price {
    private Strategy strategy;

    public Price(Strategy strategy) {
        this.strategy = strategy;
    }

    public Double resultPrice(Double price) {
        return this.strategy.memberStrategy(price);
    }
}