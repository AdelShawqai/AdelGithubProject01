# AdelGithubProject01
Test Automation: GithubProject01

This is a test change:

        By hiddenInputLocator = By.xpath("//input[@id='revealed']");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class)
                        .ignoring(NoSuchElementException.class)
                        .ignoring(StaleElementReferenceException.class)
                        .ignoring(ElementClickInterceptedException.class);
        wait.until(d -> {
            d.findElement(hiddenInputLocator).sendKeys("You found me!");
            return true;
                });
