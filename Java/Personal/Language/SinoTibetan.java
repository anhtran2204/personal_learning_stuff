class SinoTibetan extends Language {
    SinoTibetan(String languageName, int speakers) {
    super(languageName, speakers, "Asia", "Subject-Object-Verb");
      if (this.name.contains("Chinese")) {
        this.wordOrder = "Subject-Verb-Object";
      }
    }
    
    @Override
    public void getInfo() {
      System.out.println();
      System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + ".");
      System.out.println("The language follows the word order: " + this.wordOrder);
    }
  }