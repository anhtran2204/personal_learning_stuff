class Language {
    protected String name;
    protected int numSpeakers;
    protected String regionsSpoken;
    protected String wordOrder;
    
    Language(final String languageName, final int speakers, final String regions, final String order) {
      this.name = languageName;
      this.numSpeakers = speakers;
      this.regionsSpoken = regions;
      this.wordOrder = order;
    }

    public void getInfo() {
      System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + ".");
      System.out.println("The language follows the word order: " + this.wordOrder);
    }

    public static void main(final String[] args) {
      final Language vietnamese = new Language("Vietnamese", 100000000, "Vietnam", "Subject - Verb - Object");
      vietnamese.getInfo();

      final Language kiche = new Mayan("Ki'che'", 2330000);
      kiche.getInfo();

      final Language sinotibetan = new SinoTibetan("Tibetic", 1300000000);
      sinotibetan.getInfo();
      final Language mandarin = new SinoTibetan("Mandarin Chinese", 920000000);
      mandarin.getInfo();
    }
  }