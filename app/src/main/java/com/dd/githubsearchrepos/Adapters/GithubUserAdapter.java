package com.dd.githubsearchrepos.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dd.githubsearchrepos.Presenter.Presenter;
import com.dd.githubsearchrepos.R;
import com.dd.githubsearchrepos.ServerClasses.GithubUser;


public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserAdapter.ViewHolder> implements View.OnClickListener {

    private GithubUser item;
    private Context context;
    private TextView mLoginTv;
    private TextView mIdTv;
    private TextView mNodeIdTv;
    private TextView mAvatarUrlTv;
    private TextView mGravatarIdTv;
    private TextView mUrlTv;
    private TextView mHtmlUrlTv;
    private TextView mFollowersUrlTv;
    private TextView mFollowingUrlTv;
    private TextView mGistsUrlTv;
    private TextView mStarredUrlTv;
    private TextView mSubscriptionsUrlTv;
    private TextView mOrganizationsUrlTv;
    private TextView mReposUrlTv;
    private TextView mEventsUrlTv;
    private TextView mReceivedEventsUrlTv;
    private TextView mTypeTv;
    private TextView mSiteAdminTv;
    private TextView mNameTv;
    private TextView mCompanyTv;
    private TextView mBlogTv;
    private TextView mLocationTv;
    private TextView mEmailTv;
    private TextView mHireableTv;
    private TextView mBioTv;
    private TextView mPublicReposTv;
    private TextView mPublicGistsTv;
    private TextView mFollowersTv;
    private TextView mFollowingTv;
    private TextView mCreatedAtTv;
    private TextView mUpdatedAtTv;

    private Presenter presenter;

    public GithubUserAdapter(Context context, GithubUser item) {
        Log.i("autolog", "RecyclerViewAdapter");
        this.item = item;
        this.context = context;
        this.presenter = new Presenter();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("autolog", "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.items_activity_github_user, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i("autolog", "onBindViewHolder");
        holder.mLoginTv.setText(item.getLogin());
        holder.mUrlTv.setText(item.getUrl());
        holder.mIdTv.setText(String.valueOf(item.getId()));
        holder.mNodeIdTv.setText(item.getNode_id());
        holder.mAvatarUrlTv.setText(item.getAvatar_url());
        holder.mGravatarIdTv.setText(item.getGravatar_id());
        holder.mHtmlUrlTv.setText(item.getHtml_url());
        holder.mFollowersUrlTv.setText(item.getFollowers_url());
        holder.mFollowingUrlTv.setText(item.getFollowing_url());
        holder.mGistsUrlTv.setText(item.getGists_url());
        holder.mStarredUrlTv.setText(item.getStarred_url());
        holder.mSubscriptionsUrlTv.setText(item.getSubscriptions_url());
        holder.mOrganizationsUrlTv.setText(item.getOrganizations_url());
        holder.mReposUrlTv.setText(item.getRepos_url());
        holder.mEventsUrlTv.setText(item.getEvents_url());
        holder.mReceivedEventsUrlTv.setText(item.getReceived_events_url());
        holder.mTypeTv.setText(item.getType());
        holder.mNameTv.setText(item.getName());
//        holder.mCompanyTv.setText(String.valueOf(item.getCompany()));
        holder.mBlogTv.setText(item.getBlog());
//        holder.mLocationTv.setText(String.valueOf(item.getLocation()));
//        holder.mEmailTv.setText(String.valueOf(item.getEmail()));
        holder.mHireableTv.setText(String.valueOf(item.isHireable()));
//        holder.mBioTv.setText(String.valueOf(item.getBio()));
        holder.mPublicReposTv.setText(String.valueOf(item.getPublic_repos()));
        holder.mPublicGistsTv.setText(String.valueOf(item.getPublic_gists()));
        holder.mFollowersTv.setText(String.valueOf(item.getFollowers()));
        holder.mFollowingTv.setText(String.valueOf(item.getFollowing()));
        holder.mCreatedAtTv.setText(item.getCreated_at());
        holder.mUpdatedAtTv.setText(item.getUpdated_at());


    }

    private void initView(@NonNull final View itemView) {
        mLoginTv = (TextView) itemView.findViewById(R.id.tv_login);
        mIdTv = (TextView) itemView.findViewById(R.id.tv_id);
        mNodeIdTv = (TextView) itemView.findViewById(R.id.tv_node_id);
        mAvatarUrlTv = (TextView) itemView.findViewById(R.id.tv_avatar_url);
        mGravatarIdTv = (TextView) itemView.findViewById(R.id.tv_gravatar_id);
        mUrlTv = (TextView) itemView.findViewById(R.id.tv_url);
        mHtmlUrlTv = (TextView) itemView.findViewById(R.id.tv_html_url);
        mFollowersUrlTv = (TextView) itemView.findViewById(R.id.tv_followers_url);
        mFollowingUrlTv = (TextView) itemView.findViewById(R.id.tv_following_url);
        mGistsUrlTv = (TextView) itemView.findViewById(R.id.tv_gists_url);
        mStarredUrlTv = (TextView) itemView.findViewById(R.id.tv_starred_url);
        mSubscriptionsUrlTv = (TextView) itemView.findViewById(R.id.tv_subscriptions_url);
        mOrganizationsUrlTv = (TextView) itemView.findViewById(R.id.tv_organizations_url);
        mReposUrlTv = (TextView) itemView.findViewById(R.id.tv_repos_url);
        mEventsUrlTv = (TextView) itemView.findViewById(R.id.tv_events_url);
        mReceivedEventsUrlTv = (TextView) itemView.findViewById(R.id.tv_received_events_url);
        mTypeTv = (TextView) itemView.findViewById(R.id.tv_type);
        mSiteAdminTv = (TextView) itemView.findViewById(R.id.tv_site_admin);
        mNameTv = (TextView) itemView.findViewById(R.id.tv_name);
        mCompanyTv = (TextView) itemView.findViewById(R.id.tv_company);
        mBlogTv = (TextView) itemView.findViewById(R.id.tv_blog);
        mLocationTv = (TextView) itemView.findViewById(R.id.tv_location);
        mEmailTv = (TextView) itemView.findViewById(R.id.tv_email);
        mHireableTv = (TextView) itemView.findViewById(R.id.tv_hireable);
        mBioTv = (TextView) itemView.findViewById(R.id.tv_bio);
        mPublicReposTv = (TextView) itemView.findViewById(R.id.tv_public_repos);
        mPublicGistsTv = (TextView) itemView.findViewById(R.id.tv_public_gists);
        mFollowersTv = (TextView) itemView.findViewById(R.id.tv_followers);
        mFollowingTv = (TextView) itemView.findViewById(R.id.tv_following);
        mCreatedAtTv = (TextView) itemView.findViewById(R.id.tv_created_at);
        mUpdatedAtTv = (TextView) itemView.findViewById(R.id.tv_updated_at);

    }

    @Override
    public int getItemCount() {
        Log.i("autolog", "getItemCount");
        return 1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_to_favorites:

                presenter.insert(item);
                break;
            case R.id.btn_delete_to_favorites:

                presenter.delete(item);
                break;
            default:
                break;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView mLoginTv;
        private TextView mUrlTv;
        private TextView mIdTv;
        private TextView mNodeIdTv;
        private TextView mAvatarUrlTv;
        private TextView mGravatarIdTv;
        private TextView mHtmlUrlTv;
        private TextView mFollowersUrlTv;
        private TextView mFollowingUrlTv;
        private TextView mGistsUrlTv;
        private TextView mStarredUrlTv;
        private TextView mSubscriptionsUrlTv;
        private TextView mOrganizationsUrlTv;
        private TextView mReposUrlTv;
        private TextView mEventsUrlTv;
        private TextView mReceivedEventsUrlTv;
        private TextView mTypeTv;
        private TextView mSiteAdminTv;
        private TextView mNameTv;
        private TextView mCompanyTv;
        private TextView mBlogTv;
        private TextView mLocationTv;
        private TextView mEmailTv;
        private TextView mHireableTv;
        private TextView mBioTv;
        private TextView mPublicReposTv;
        private TextView mPublicGistsTv;
        private TextView mFollowersTv;
        private TextView mFollowingTv;
        private TextView mCreatedAtTv;
        private TextView mUpdatedAtTv;


        public ViewHolder(View itemView) {
            super(itemView);
            Log.i("autolog", "ViewHolder");
            initView(itemView);

        }

        private void initView(@NonNull final View itemView) {
            mLoginTv = (TextView) itemView.findViewById(R.id.tv_login);
            mUrlTv = (TextView) itemView.findViewById(R.id.tv_url);
            mIdTv = (TextView) itemView.findViewById(R.id.tv_id);
            mNodeIdTv = (TextView) itemView.findViewById(R.id.tv_node_id);
            mAvatarUrlTv = (TextView) itemView.findViewById(R.id.tv_avatar_url);
            mGravatarIdTv = (TextView) itemView.findViewById(R.id.tv_gravatar_id);
            mHtmlUrlTv = (TextView) itemView.findViewById(R.id.tv_html_url);
            mFollowersUrlTv = (TextView) itemView.findViewById(R.id.tv_followers_url);
            mFollowingUrlTv = (TextView) itemView.findViewById(R.id.tv_following_url);
            mGistsUrlTv = (TextView) itemView.findViewById(R.id.tv_gists_url);
            mStarredUrlTv = (TextView) itemView.findViewById(R.id.tv_starred_url);
            mSubscriptionsUrlTv = (TextView) itemView.findViewById(R.id.tv_subscriptions_url);
            mOrganizationsUrlTv = (TextView) itemView.findViewById(R.id.tv_organizations_url);
            mReposUrlTv = (TextView) itemView.findViewById(R.id.tv_repos_url);
            mEventsUrlTv = (TextView) itemView.findViewById(R.id.tv_events_url);
            mReceivedEventsUrlTv = (TextView) itemView.findViewById(R.id.tv_received_events_url);
            mTypeTv = (TextView) itemView.findViewById(R.id.tv_type);
            mSiteAdminTv = (TextView) itemView.findViewById(R.id.tv_site_admin);
            mNameTv = (TextView) itemView.findViewById(R.id.tv_name);
            mCompanyTv = (TextView) itemView.findViewById(R.id.tv_company);
            mBlogTv = (TextView) itemView.findViewById(R.id.tv_blog);
            mLocationTv = (TextView) itemView.findViewById(R.id.tv_location);
            mEmailTv = (TextView) itemView.findViewById(R.id.tv_email);
            mHireableTv = (TextView) itemView.findViewById(R.id.tv_hireable);
            mBioTv = (TextView) itemView.findViewById(R.id.tv_bio);
            mPublicReposTv = (TextView) itemView.findViewById(R.id.tv_public_repos);
            mPublicGistsTv = (TextView) itemView.findViewById(R.id.tv_public_gists);
            mFollowersTv = (TextView) itemView.findViewById(R.id.tv_followers);
            mFollowingTv = (TextView) itemView.findViewById(R.id.tv_following);
            mCreatedAtTv = (TextView) itemView.findViewById(R.id.tv_created_at);
            mUpdatedAtTv = (TextView) itemView.findViewById(R.id.tv_updated_at);
        }
    }
}
