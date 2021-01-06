package donkers.kevin.cocktailapp.domain;

public enum Difficulty {
    VERY_EASY {
        public String toString() {
            return "1. Very Easy";
        }
    },
    EASY {
        public String toString() {
            return "2. Easy";
        }
    },
    MODERATE {
        public String toString() {
            return "3. Moderate";
        }
    },
    HARD {
        public String toString() {
            return "4. Hard";
        }
    },
    VERY_HARD{
        public String toString() {
            return "5. Very Hard";
        }
    };

}
