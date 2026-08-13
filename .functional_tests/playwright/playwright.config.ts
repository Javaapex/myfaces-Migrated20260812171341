import { defineConfig } from '@playwright/test';

export default defineConfig({
  testDir: '.',
  timeout: 60000,
  use: {
    baseURL: process.env.BASE_URL || 'http://127.0.0.1:61724',
    trace: 'on',
    screenshot: 'on',
    video: 'on',
    ignoreHTTPSErrors: true,
  },
  reporter: [
    ['html', { outputFolder: 'playwright-report' }],
    ['allure-playwright', { outputFolder: 'allure-results' }],
  ],
});
