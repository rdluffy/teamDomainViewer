package org.kaizoku.cryptography.digest;



/*
    Test if digest is working
 */
public class DigestTest {
    @org.testng.annotations.Test
    public void testHash_by_SHA256_to_base64() throws Exception {
        String res =  Digest.hash_by_SHA256_to_base64("Stef");
        assertThat(res).isEqualTo("YmE3ODE2YmY4ZjAxY2ZlYTQxNDE0MGRlNWRhZTIyMjNiMDAzNjFhMzk2MTc3YTljYjQxMGZmNjFmMjAwMTVhZA==");

    }
}
