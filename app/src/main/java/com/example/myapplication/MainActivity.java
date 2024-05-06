public class MainActivity extends AppCompatActivity {

    private EditText urlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditText = findViewById(R.id.urlEditText);
        Button openButton = findViewById(R.id.openButton);

        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlEditText.getText().toString().trim();

                if (isValidUrl(url)) {
                    openBrowser(url);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid URL", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidUrl(String url) {
        // Simple URL validation
        return Patterns.WEB_URL.matcher(url).matches();
    }

    private void openBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
