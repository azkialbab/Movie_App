package com.example.movieapp

import Movie
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val movieList = listOf(
        Movie(
            poster = R.drawable.venom,
            title = "Venom: The Last Dance",
            duration = "1h 40m",
            ageLimit = "R13+",
            genre = "Action",
            synopsis = "Venom: The Last Dance follows Eddie Brock, played by Tom Hardy, as he struggles to balance his life as a journalist with being the host of the alien symbiote, Venom. The film sees Eddie and Venom facing a new, dangerous enemy that threatens their safety and tests their bond. It explores themes of friendship, sacrifice, and collaboration as they navigate moral dilemmas. With thrilling action, humor, and character development, the film delivers an engaging superhero experience, culminating in Eddie and Venom uniting against a greater threat to secure a better future."
        ),
        Movie(
            poster = R.drawable.musyrik,
            title = "MUSYRIK",
            duration = "1h 32m",
            ageLimit = "D17+",
            genre = "Horror",
            synopsis = "Musyrik is an Indonesian horror film about a group of friends who travel to a remote village seeking new experiences. They soon discover that the village harbors dark secrets related to shirk practices and dangerous rituals.\n" +
                    "\n" +
                    "As they become trapped in increasingly terrifying situations, they experience strange occurrences and the strong influence of malevolent forces threatening their lives. Each member must confront their deepest fears and moral choices that test their friendships."
        ),
        Movie(
            poster = R.drawable.insideout,
            title = "Inside Out 2",
            duration = "1h 36m",
            ageLimit = "SU",
            genre = "Animated, Comedy",
            synopsis = "Inside Out 2 continues the story of Riley as she navigates her teenage years. Now a young teen, Riley's emotions—Joy, Sadness, Anger, Fear, and Disgust—must adapt to the complexities of her new experiences, including friendships, identity, and changing family dynamics.\n" +
                    "\n" +
                    "As Riley faces the ups and downs of adolescence, her emotions encounter new challenges and characters, introducing a fresh set of feelings that reflect her evolving personality. Joy, in particular, learns the importance of embracing not just happiness, but the full spectrum of emotions that come with growing up.\n" +
                    "\n" +
                    "The film explores themes of growth, self-discovery, and the significance of all emotions in shaping who we are, emphasizing that it's okay to feel a mix of emotions as we navigate life's changes. Through a blend of humor and heart, Inside Out 2 showcases Riley's journey toward understanding herself in a world filled with new emotions and experiences."
        ),
        Movie(
            poster = R.drawable.transform,
            title = "Transformer One",
            duration = "1h 44m",
            ageLimit = "R13+",
            genre = "Animated, Comedy",
            synopsis = "Transformers: One is an animated film that serves as a prequel to the live-action Transformers series, exploring the origins of the Autobots and Decepticons on their home planet, Cybertron. The story focuses on the early days of the war between these two factions, delving into the relationships and conflicts that shape their destinies.\n" +
                    "\n" +
                    "The film centers around a young Optimus Prime and his journey from a soldier to a leader, as he confronts the rising threat of Megatron and his followers. As the Autobots strive to protect their planet and its inhabitants, they must grapple with themes of loyalty, sacrifice, and the consequences of war.\n" +
                    "\n" +
                    "Through stunning animation and epic battles, Transformers: One aims to provide fans with a deeper understanding of the lore and character dynamics that define the beloved franchise, highlighting the struggles and triumphs that lead to the iconic conflict between Autobots and Decepticons."
        ),
        Movie(
            poster = R.drawable.canary,
            title = "Canary Black",
            duration = "2h 10m",
            ageLimit = "R13+",
            genre = "Action",
            synopsis = "Canary Black is an upcoming thriller film centered around the world of espionage and intrigue. The story follows a former intelligence operative who finds herself drawn back into the shadows after a series of mysterious events disrupt her quiet life.\n" +
                    "\n" +
                    "As she navigates a treacherous landscape filled with deceit and danger, she uncovers a conspiracy that threatens not only her safety but also the lives of those she loves. With her skills put to the test, she must confront her past and outsmart her enemies to survive.\n" +
                    "\n" +
                    "The film explores themes of loyalty, betrayal, and the moral complexities of the spy world, offering viewers a gripping narrative filled with suspense and unexpected twists. As tensions rise and the stakes become higher, the protagonist must decide who to trust in a game where everyone has their own agenda."
        ),
        Movie(
            poster = R.drawable.robot,
            title = "The Wild Robot",
            duration = "1h 30m",
            ageLimit = "SU",
            genre = "Animation, Adventure",
            synopsis = "The Wild Robot is an animated film adaptation of Peter Brown's children's novel. It follows Roz, a robot who awakens on a remote island after a shipwreck, where she must adapt to life in the wild. Initially feared by the island's animals, Roz gradually earns their trust and forms close bonds, especially with a young gosling named Brightbill, whom she raises after it loses its mother.\n" +
                    "\n" +
                    "As Roz navigates the challenges of her new environment, she learns about friendship, community, and the beauty of nature. The film explores themes of belonging, the relationship between technology and the natural world, and the importance of protecting those we care about. With heartwarming moments and stunning visuals, The Wild Robot conveys a story of growth and connection for audiences of all ages."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mengatur RecyclerView
        binding.rvMovie.layoutManager = GridLayoutManager(requireContext(), 2) // Atur jumlah kolom
        val movieAdapter = MovieAdapter(movieList) { movie ->
            openMovieDetail(movie)
        }
        binding.rvMovie.adapter = movieAdapter

    }

    private fun openMovieDetail(movie: Movie) {
        val intent = Intent(requireContext(), MovieDetailActivity::class.java)
        intent.putExtra("TITLE", movie.title)
        intent.putExtra("GENRE", movie.genre)
        intent.putExtra("SYNOPSIS", movie.synopsis)
        intent.putExtra("DURATION", movie.duration)
        intent.putExtra("AGE_LIMIT", movie.ageLimit)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}