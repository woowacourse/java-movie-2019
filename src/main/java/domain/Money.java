package domain;

public class Money {
        public long money;

        public Money(long money){
                this.money = money;
        }

        public boolean isValidMoney(int point){
                if(money - point < 0){
                        return false;
                }
                return true;
        }

        public void calculatePoint(long point){
               this.money = this.money - point;
        }
}
